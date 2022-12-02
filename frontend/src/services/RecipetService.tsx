import { Recipet } from "../models/RecipetModel"

class RecipetService {

    private static readonly url = "http://localhost:8080/recipet"

    static generatePDFRecipet(recipet: Recipet): Promise<void> {
        const headers = new Headers()
        headers.append("Content-Type", "application/json")
        return fetch(RecipetService.url, {
            method: "POST",
            headers: headers,
            body: JSON.stringify(recipet),

        })  
            .then(res => res.blob())
            .then(blob => {
                const nBlob = new Blob([blob], {type: "application/pdf"})
                const downloadURL = window.URL.createObjectURL(nBlob)
                window.open(downloadURL,'__blank')
            })
            .catch(e => {
                console.error(e)
            })
    }

}

export { RecipetService }