import React from "react";
import ReactDOM from "react-dom";
import axios from "axios";
import "./index.css";

class Input extends React.Component {
  constructor() {
    super();
    this.state = {
      entrada: "",
      valor: ""
    };
    this.onChange = (evento) => {
      this.setState({ entrada: evento.target.value });

    };
    this.onSubmit = (evento) => {
      evento.preventDefault();
      axios
        .get(
          "https://desafiobridgeheroku.herokuapp.com/desafio?entrada=" +
            this.state.entrada
        )
        .then((res) => this.setState({valor: res.data}))
        .catch((err) => console.log(err));
    };
  }
  render() {
    return (
      <div>
        Entrada:{" "}
        <input
          name="entrada"
          value={this.state.entrada}
          onChange={this.onChange}
          type="number"
        />
        <button type="submit" onClick={this.onSubmit}>
          {" "}
          Enviar{" "}
        </button>
        Resultado: <h1>{this.state.valor}</h1>
      </div>
    )
  }
}
ReactDOM.render(<Input />, document.getElementById("root"));
export default Input;
