import React from "react";
import ReactDOM from "react-dom";
import axios from "axios";
import "./index.css";

class Input extends React.Component {
  componentDidMount() {
    document.title = "Desafio Bridge"; 
 }
  constructor() {
    super();

    this.state = {
      entrada: "",
      valor: {resultado:null, tempodeexecucao:null}
    };
    this.onChange = (evento) => {
      this.setState({ entrada: evento.target.value });

    };
    this.onSubmit = (evento) => {
      evento.preventDefault();
      if (this.state.entrada > 1){
        axios.defaults.headers.get['Content-Type'] ='application/json;charset=utf-8';
        axios.defaults.headers.get['Access-Control-Allow-Origin'] = '*';
        
        axios
        .get(
          "https://desafiobridgeheroku.herokuapp.com/desafio?entrada=" +
            this.state.entrada, {withCredentials: false}
        )
        .then((res) => this.setState({valor: res.data}))
        .catch((err) => console.log(err));
      }else{
        this.setState({valor:{resultado: "Numero tem que ser maior que 1", tempodeexecucao:null}});
      }

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
        <text>{this.state.valor.resultado == null ? "Digite um número maior que 1":"Resultado: "}</text><h2>{this.state.valor.resultado}</h2>
        <text>{this.state.valor.tempodeexecucao == null ? "":"Tempo de Execução: "}</text><h2>{this.state.valor.tempodeexecucao == null ? "": this.state.valor.tempodeexecucao + 'ms'}</h2>
        <p>Feito por Micael Presotto💙</p>
      </div>
    )
  }
}
ReactDOM.render(<Input />, document.getElementById("root"));
export default Input;
