import React, { useEffect, useState } from 'react';

export default function Main() {
    const [transactionData, setTransactionData] = useState({
        totalIncome: 0,
        totalExpenses: 0,
        netBalance: 0,
        budgetOverview: 0,
        weeklyTotals: [0, 0, 0, 0],
        categoryData: [0, 0, 0, 0, 0],
    });

    // Fetch transactions and calculate weekly totals
    const fetchWeeklyTotals = async () => {
        try {
            const response = await fetch('http://localhost:8080/api/v1/transaction');
            const data = await response.json();

            let [week1, week2, week3, week4] = [new Date(), new Date(), new Date(), new Date()];
            const currentDate = new Date();

            week1.setDate(currentDate.getDate() - 7);
            week2.setDate(currentDate.getDate() - 14);
            week3.setDate(currentDate.getDate() - 21);
            week4.setDate(currentDate.getDate() - 28);

            let [totalweek1, totalweek2, totalweek3, totalweek4] = [0, 0, 0, 0];

            data.forEach((transaction) => {
                const transactionDate = new Date(transaction.date);
                const amount = transaction.type === "DEPOSIT" || transaction.type === "REFUND" ? transaction.amount : -transaction.amount;

                if (transactionDate > week1) totalweek1 += amount;
                else if (transactionDate > week2) totalweek2 += amount;
                else if (transactionDate > week3) totalweek3 += amount;
                else if (transactionDate > week4) totalweek4 += amount;
            });

            setTransactionData(prevState => ({
                ...prevState,
                weeklyTotals: [totalweek1, totalweek2, totalweek3, totalweek4],
            }));
        } catch (error) {
            console.error('Error fetching transactions:', error);
        }
    };

    // Fetch transaction categories for chart
    const fetchCategoryData = async () => {
        try {
            const response = await fetch('http://localhost:8080/api/v1/transaction');
            const data = await response.json();

            let [purchase, refund, transfer, withdrawal, deposit] = [0, 0, 0, 0, 0];

            data.forEach((transaction) => {
                switch (transaction.type) {
                    case "PURCHASE":
                        purchase++;
                        break;
                    case "REFUND":
                        refund++;
                        break;
                    case "TRANSFER":
                        transfer++;
                        break;
                    case "WITHDRAWAL":
                        withdrawal++;
                        break;
                    case "DEPOSIT":
                        deposit++;
                        break;
                    default:
                        break;
                }
            });

            setTransactionData(prevState => ({
                ...prevState,
                categoryData: [purchase, refund, transfer, withdrawal, deposit],
            }));
        } catch (error) {
            console.error('Error fetching transaction categories:', error);
        }
    };

    useEffect(() => {
        fetchWeeklyTotals();
        fetchCategoryData();
    }, []);

    return (
        <div>
            {/* Display Weekly Expense Chart */}
            <canvas id="monthlyExpenseChart"></canvas>

            {/* Display Category Breakdown Chart */}
            <canvas id="categoryBreakdownChart"></canvas>

            {/* Additional JSX for transactions list and other elements */}
        </div>
    );
}