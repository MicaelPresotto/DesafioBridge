import React from "react";
import ReactDOM from "react-dom";
import axios from "axios"; // importando a biblioteca axios
import "./index.css";

class Input extends React.Component {
  componentDidMount() {
    document.title = "Desafio Bridge"; // mudando o título da página
 }
  constructor() {
    super();
    this.state = {
      entrada: "",
      valor: {resultado:null, tempodeexecucao:null} // setando a entrada e o valor(que vai receber o resultado e o tempo de execucao)
    };
    this.onChange = (evento) => { // função que sera utilizada no input
      this.setState({ entrada: evento.target.value }); //setando o estado da entrada

    };
    this.onSubmit = (evento) => { //vou utilizar essa função la no botao para quando o usario clicar retornar ela
      evento.preventDefault();
      if (this.state.entrada > 1){
        axios.defaults.headers.get['Content-Type'] ='application/json;charset=utf-8';
        axios.defaults.headers.get['Access-Control-Allow-Origin'] = '*'; //tive alguns erros CORS entao utilizei isso e o @CrossOrigin no backend para resolver
        
        axios
        .get(
          "https://desafiobridgeheroku.herokuapp.com/desafio?entrada=" +
            this.state.entrada, {withCredentials: false} //pegando os retornos no backend e colocando no valor
        )
        .then((res) => this.setState({valor: res.data}))
        .catch((err) => console.log(err));
      }else{
        this.setState({valor:{resultado: "Numero tem que ser maior que 1", tempodeexecucao:null}});// verificação se acaso o numero for menor que 1
      }

    };
  }
  render() { // parte do HTML
    return (
      <div>
        <h1>Desafio Bridge</h1>
        <span>Entrada:</span>
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
        <span>{this.state.valor.resultado == null ? "Digite um número maior que 1":"Resultado: "}</span><h2>{this.state.valor.resultado}</h2>
        <span>{this.state.valor.tempodeexecucao == null ? "":"Tempo de Execução: "}</span><h2>{this.state.valor.tempodeexecucao == null ? "": this.state.valor.tempodeexecucao + 'ms'}</h2>
        <p>Feito por Micael Angelo Sabadin Presotto💙</p>
      </div>
    )// nao consegui comentar dentro do html com <!-- -->
    // porem linhas apos o <br>, estou apenas pegando os valores que estão sendo dados pelo hashmap do backend, como falei é um dicionario, por isso eu pegado this.state.valor.resultado, onde resultado é a key.
  }
}
ReactDOM.render(<Input />, document.getElementById("root"));
export default Input;
