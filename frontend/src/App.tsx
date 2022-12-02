import { useState } from 'react'
import axios from 'axios'
import { Container } from './components/Container';
import { FormRecipet } from './components/FormRecipet';

function App() {
  const [count, setCount] = useState(0)

  const getReport = async() => {
    const data = {
      "number": 1,
      "value": 3200.99,
      "creditor": "Yorick O Pastor de Almas",
      "debtor": "Zaunita amorfo de combate (Zac)",
      "referent": "Bastão das Eras",
      "place": "Summoners Rift - Rune Terra",
      "rgCpf": "84483198009"
    };
    const response = await axios.post("http://localhost:8080/recipet", data, {
      responseType: 'blob',
      proxy: false
    });

    const downloadURL = window.URL.createObjectURL(response.data);

    window.open(downloadURL,'__blank')

  }

  return (
    <Container>
      <FormRecipet />
    </Container>
  )
}

export default App
