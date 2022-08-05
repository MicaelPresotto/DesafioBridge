import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'
import App from './App'

class Input extends React.Component {
  render() {
    return (
      <div>
        Entrada: <input name="Entrada" type="number" />
      </div>
    )
  }
}
ReactDOM.render(<Input />, document.getElementById('root'))
const root = ReactDOM.createRoot(document.getElementById('root'))
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
)
