import { ReactNode } from "react"

interface Props {
    children: ReactNode
}

import styles from "./Container.module.css"

function Container({ children }: Props) {
    return (
        <div className={styles.container}>
            { children }
        </div>
    )
}

export { Container }