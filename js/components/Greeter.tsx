import * as React from "react";

import { grpc, BrowserHeaders } from "grpc-web-client";

import { HelloRequest, HelloResponse } from "../gen/helloworld_pb";
import { HelloService } from "../gen/helloworld_pb_service";

const API_URL = process.env.API_URL as string;

interface State {
  name: string;
  greeting: string;
  formErrors: string;
}

interface Props {
}

/** A Component that allows the user to enter their name and see a greeting based on it. */
export class Greeter extends React.Component<Props, State> {

  constructor(props: Props) {
    super(props);

    this.state = {
      name: "",
      greeting: "",
      formErrors: ""
    };
  }

  handleName = (e: React.FormEvent<HTMLInputElement>) => {
    this.setState({ name: e.currentTarget.value });
  }

  onSubmit = () => {
		if(!this.state.name) {
			this.setState({ formErrors: "Please enter a name" })
      return;
		}
		this.setState({ formErrors: "" });

    let request = new HelloRequest();
    request.setName(this.state.name);

    console.log(`calling ${API_URL}`);
    grpc.invoke(HelloService.SayHello, {
      request: request,
      headers: new BrowserHeaders({
          "authorization": "Bearer ABC.DEF.XYZ",
      }),
      host: API_URL,
      onHeaders: (headers: BrowserHeaders) => {},
      onMessage: (message: HelloResponse) => {
        this.setState({ greeting: message.getMessage() });
      },
      onEnd: (code: grpc.Code, msg: string, trailers: BrowserHeaders) => {
        if (code == grpc.Code.OK) {
          console.log("all ok")
        } else {
          console.log("hit an error", code, msg, trailers);
        }
      },
    });
  }

  render() {
    return (
      <div className="greeting-container">
        <div className="errors">
          {this.state.formErrors}
        </div>
        <div className="greeting">
          {this.state.greeting}
        </div>
        <div className="field">
          <input
            value={this.state.name}
            name="name"
            type="text"
            onChange={this.handleName}
            placeholder="Enter name..."
            required />
        </div>
        <button
          className="submit-button"
          onClick={this.onSubmit}>
          Greet
        </button>
      </div>
    );
  }
};
