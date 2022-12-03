class Recipet {
    constructor(
        public number: number = 0,
        public value: number = 0,
        public creditor: string = "★★★★★★★★",
        public debtor: string = "★★★★★★★★",
        public referent: string = "★★★★★★★★",
        public place: string = "★★★★★★★★",
        public cityUf: string = "★★★★★★★★-★★ ",
        public rgCpf: string = "★★★.★★★.★★★-★★",
        public date: string = "0001-01-01"
    ) { }
}

export { Recipet }