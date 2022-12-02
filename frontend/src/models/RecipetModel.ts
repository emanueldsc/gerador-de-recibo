class Recipet {
    constructor(
        public number: number = 1,
        public value: number = 1500.90,
        public creditor: string = "Emanuel Douglas",
        public debtor: string = "Outra Pessoa",
        public referent: string = "Um celular",
        public place: string = "Rua Olimio De Noronha, 490",
        public cityUF: string = "Fortaleza-CE ",
        public rgCpf: string = "12989067809",
        public date: string = "06/12/1990"
    ) { }
}

export { Recipet }