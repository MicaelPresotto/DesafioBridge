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
        <h1>Desafio Bridge</h1>
        <text>Entrada:</text>
        <input
          name="entrada"
          value={this.state.entrada}
          onChange={this.onChange}
          type="number"
          placeholder="Digite um número"
        />
        <button type="submit" onClick={this.onSubmit}>
          Enviar{" "}
        </button>
        <br></br>
        <text>Resultado: </text><h2>{this.state.valor.Resultado}</h2>
        <text>Tempo de Execução: </text><h2>{this.state.valor.TempoDeExecucao} ms</h2>
        <p>Feito por Micael Presotto💙</p>
      </div>
    )
  }
}
ReactDOM.render(<Input />, document.getElementById("root"));
export default Input;
