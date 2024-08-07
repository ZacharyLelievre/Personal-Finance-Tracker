let totalIncome = 0;
let totalExpenses = 0;
let netBalance = 0;
let budgetOverview = 0;
//let totalArray=[];
//function

function monthTransactions(){

    return fetch('http://localhost:8080/api/v1/transaction')
        .then(response => response.json())
        .then(data => {
            let week1=new Date();
            let week2=new Date();
            let week3=new Date();
            let week4=new Date();
            let currentdate= new Date();
            week1.setDate(currentdate.getDate()-7);
            week2.setDate(currentdate.getDate()-14);
            week3.setDate(currentdate.getDate()-21);
            week4.setDate(currentdate.getDate()-28);

            let totalweek1=0;
            let totalweek2=0;
            let totalweek3=0;
            let totalweek4=0;



            data.forEach((transaction)=>{
                let transactionDate= new Date(transaction.date)

                if(transactionDate<currentdate&&transactionDate>week1){
                    //totalweek1+=transaction.amount;
                    if (transaction.type === "DEPOSIT" || transaction.type === "REFUND") {
                        totalweek1 += transaction.amount;
                    } else if (transaction.type === "PURCHASE" || transaction.type === "TRANSFER" || transaction.type === "WITHDRAWAL") {
                        totalweek1 -= transaction.amount;
                    }
                }else if(transactionDate<week1&&transactionDate>week2){
                    //totalweek2+=transaction.amount;
                    if (transaction.type === "DEPOSIT" || transaction.type === "REFUND") {
                        totalweek2 += transaction.amount;
                    } else if (transaction.type === "PURCHASE" || transaction.type === "TRANSFER" || transaction.type === "WITHDRAWAL") {
                        totalweek2 -= transaction.amount;
                    }

                }else if(transactionDate<week2&&transactionDate>week3){
                    // totalweek3+=transaction.amount;
                    if (transaction.type === "DEPOSIT" || transaction.type === "REFUND") {
                        totalweek3 += transaction.amount;
                    } else if (transaction.type === "PURCHASE" || transaction.type === "TRANSFER" || transaction.type === "WITHDRAWAL") {
                        totalweek3 -= transaction.amount;
                    }
                }
                else if(transactionDate<week3&&transactionDate>week4){
                    //totalweek4+=transaction.amount;
                    if (transaction.type === "DEPOSIT" || transaction.type === "REFUND") {
                        totalweek4 += transaction.amount;
                    } else if (transaction.type === "PURCHASE" || transaction.type === "TRANSFER" || transaction.type === "WITHDRAWAL") {
                        totalweek4 -= transaction.amount;
                    }
                }

            })

            return[totalweek1,totalweek2,totalweek3,totalweek4];

        })
        .catch(error=>{
            console.error('Error fetching transactions:', error);
            return [];
        });






}

//console.log(monthTransactions());

function displayTransaction() {
    let totalIncome = 0;
    let totalExpenses = 0;
    let netBalance = 0;
    let budgetOverview = 0;

    fetch('http://localhost:8080/api/v1/transaction')
        .then(response => response.json())
        .then(data => {
            let transactionList = document.getElementById('transactions');
            data.forEach(transaction => {
                let listItem = document.createElement('li');
                listItem.textContent = `ID: ${transaction.id}, Type: ${transaction.type}, Amount: $${transaction.amount}, Date: ${transaction.date}`;
                transactionList.appendChild(listItem);

                if (transaction.type === "DEPOSIT" || transaction.type === "REFUND") {
                    totalIncome += transaction.amount;
                    document.getElementById("income").textContent = totalIncome;
                } else if (transaction.type === "PURCHASE" || transaction.type === "TRANSFER" || transaction.type === "WITHDRAWAL") {
                    totalExpenses -= transaction.amount;
                    document.getElementById('expense').textContent = totalExpenses;
                }
                netBalance = totalIncome + totalExpenses; //here total expenses are in negative meaning its -150, not 150 of expenses
                document.getElementById('net').textContent = netBalance;

                // budgetOverview=
            });
        })
}
displayTransaction();

document.getElementById('add').addEventListener('click', () => {
    let amount = document.getElementById('amount').value;
    let type = document.getElementById('typeOfTransaction').value;
    let date = document.getElementById('dates').value;

    const transaction = {
        amount: amount,
        type: type,
        date: date
    }

    fetch('http://localhost:8080/api/v1/transaction', {
        headers: {
            'Accepts': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify(transaction)
    })
        .then(data => {
            displayTransaction();
        })

})

monthTransactions().then(totalArray=>{



    // Monthly Expense Chart
    const monthlyExpenseCtx = document.getElementById('monthlyExpenseChart').getContext('2d');
    const monthlyExpenseChart = new Chart(monthlyExpenseCtx, {
        type: 'bar',
        data: {
            labels: ['Week 1', 'Week 2', 'Week 3', 'Week 4'],
            datasets: [{
                label: 'Expenses',
                data: totalArray,
                backgroundColor: '#4CAF50',
                borderColor: 'black',
                borderWidth: 3
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    })
});
function categoryChart(){
    return fetch('http://localhost:8080/api/v1/transaction')
        .then(response => response.json())
        .then(data => {

            let purchase=0;
            let refund=0;
            let transfer=0;
            let withdrawal=0;
            let deposit=0;




            data.forEach((transaction)=>{
                if(transaction.type==="PURCHASE"){
                    purchase++;

                }else if(transaction.type==="REFUND"){
                    refund++;

                }else if(transaction.type==="TRANSFER"){
                    transfer++;

                }else if(transaction.type==="WITHDRAWAL"){
                    withdrawal++;

                }else if(transaction.type==="DEPOSIT"){
                    deposit++;
                }


            })
            return [purchase,refund,transfer,withdrawal,deposit];

        })

}



categoryChart().then((category)=>{

    const categoryBreakdownChartCtx = document.getElementById('categoryBreakdownChart').getContext('2d');
    const categoryBreakdownChartChart = new Chart(categoryBreakdownChartCtx, {
        type: 'pie',
        data: {
            labels: ['PURCHASE', 'REFUND', 'TRANSFER', 'WITHDRAWAL','DEPOSIT'],
            datasets: [{
                label: 'Expenses',
                data: category,
                backgroundColor: '#4CAF50',
                borderColor: 'black',
                borderWidth: 3
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
})