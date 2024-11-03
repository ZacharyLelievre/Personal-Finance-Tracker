// @ts-ignore
import React, { useState } from 'react';
// @ts-ignore
import { Transactions } from './Transactions';

interface FormProps {
    input: (list: Transactions[]) => void;
}

const Form = ({ input }: FormProps) => {
    const [list, setList] = useState<Transactions[]>([]);


    function addToList(transaction: Transactions) {
        const newList = [...list, transaction];
        setList(newList);
        input(newList);
    }

    return (
        <div>
            {/* Render the list or other components here */}
        </div>
    );
};

export default Form;

