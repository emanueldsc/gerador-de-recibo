import { BaseSyntheticEvent, FormEvent, useState } from "react"
import { Recipet } from "../models/RecipetModel"
import { RecipetService } from "../services/RecipetService"
import styles from "./FormRecipet.module.css"

function FormRecipet() {

    const [recipet, setRecipet] = useState(new Recipet())

    function gerarRecibo(e: FormEvent<HTMLFormElement>): void {
        e.preventDefault()
        debugger
        RecipetService.generatePDFRecipet(recipet)
    }

    function handleInput(e: BaseSyntheticEvent): void {
        setRecipet({ ...recipet, [e.target.name]: e.target.value })
    }


    return (
        <div>
            <form className="w3-container" action="/action_page.php" onSubmit={gerarRecibo}>
                <h2 className="w3-text-blue text-center">Recibo</h2>
                <div className={styles.rowFlex}>
                    <div className="w3-half">
                        <label className="w3-text-blue"><b>N&ordm;</b></label>
                        <input className="w3-input w3-border" onChange={handleInput} name="number" type="number" />
                    </div>
                    <div className="w3-half">
                        <label className="w3-text-blue"><b>Valor</b></label>
                        <input className="w3-input w3-border" onChange={handleInput} name="value" type="number" />
                    </div>
                </div>
                <div className={styles.rowFlex}>
                    <div className="w3-col">
                        <label className="w3-text-blue"><b>Recebi(emos) de</b></label>
                        <input className="w3-input w3-border" onChange={handleInput} name="debtor" type="text" />
                    </div>
                </div>
                <div className={styles.rowFlex}>
                    <div className="w3-col">
                        <label className="w3-text-blue"><b>Endereço</b></label>
                        <input className="w3-input w3-border" onChange={handleInput} name="place" type="text" />
                    </div>
                </div>
                <div className={styles.rowFlex}>
                    <div className="w3-col">
                        <label className="w3-text-blue"><b>A import&acirc;ncia</b></label>
                        <input className="w3-input w3-border" tabIndex={-1} name="value" value={recipet.value} readOnly type="text" />
                    </div>
                </div>
                <div className={styles.rowFlex}>
                    <div className="w3-col">
                        <label className="w3-text-blue"><b>Referente</b></label>
                        <input className="w3-input w3-border" onChange={handleInput} name="referent" type="text" />
                    </div>
                </div>
                <div className={styles.rowFlex}>
                    <div className="w3-half">
                        <label className="w3-text-blue"><b>Cidade-UF</b></label>
                        <input className="w3-input w3-border" onChange={handleInput} name="cityUf" type="text" />
                    </div>
                    <div className="w3-half">
                        <label className="w3-text-blue"><b>Data</b></label>
                        <input className="w3-input w3-border" onChange={handleInput} name="date" type="date" />
                    </div>
                </div>
                <div className={styles.rowFlex}>
                    <div className="w3-half">
                        <label className="w3-text-blue"><b>Emitente</b></label>
                        <input className="w3-input w3-border" onChange={handleInput} name="creditor" type="text" />
                    </div>
                    <div className="w3-half">
                        <label className="w3-text-blue"><b>RG/CPF</b></label>
                        <input className="w3-input w3-border" onChange={handleInput} name="rgCpf" type="text" />
                    </div>
                </div>
                <div className="w3-section">
                    <button type="submit" className="w3-btn w3-block w3-blue">Gerar Recibo</button>
                </div>
            </form>
        </div>
    )
}

export { FormRecipet }
