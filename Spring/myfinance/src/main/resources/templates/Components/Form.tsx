// @ts-ignore
import React, { useState } from 'react';
// @ts-ignore
import { Transactions } from './Transactions';

interface FormProps {
    input: (list: Transactions[]) => void;
}

const Form = ({ input }: FormProps) => {
    const [list, setList] = useState<string>([]);


    function addToList(items: string) {
        const newList = [...list, items];
        setList(newList);
        input(newList);
    }

    return (
        <div>
            <input id="idinput" placeholder="Enter items"></input>
            <button onClick={() => addToList((document.getElementById("idinput") as HTMLInputElement).value)}>Add</button>
        </div>
    );
};

export default Form;

