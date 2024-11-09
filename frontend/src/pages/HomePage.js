

export default function HomePage() {

    return (
        <div>
            <header>Finance Tracker</header>


            <ul>
                <li><a href="/homepage">Home</a></li>
                <li><a href="/news">News</a></li>
                <li><a href="/report">Report</a></li>
                <li><a href="/about">About</a></li>
            </ul>


            <div class="container">
                <div class="overview">
                    <div class="card">
                        <h2>Total Income</h2>
                        <p id="income"></p>
                    </div>
                    <div class="card">
                        <h2>Total Expenses</h2>
                        <p id="expense"></p>
                    </div>
                    <div class="card">
                        <h2>Net Balance</h2>
                        <p id="net"></p>
                    </div>
                    <div class="card">
                        <h2>Budget Overview</h2>
                        <p>75% of Budget Used</p>
                    </div>
                </div>
            </div>

            <div class="quickadd">
                <h3>Quick Add Transaction</h3>
                <input type="number" id="amount" placeholder="Amount"/>
                <select id="typeOfTransaction">
                    <option id="DEPOSIT">DEPOSIT</option>
                    <option id="PURCHASE">PURCHASE</option>
                    <option id="TRANSFER">TRANSFER</option>
                    <option id="WITHDRAWAL">WITHDRAWAL</option>
                    <option id="REFUND">REFUND</option>
                </select>
                <input type="date" id="dates" required/>
                <button id="add">Submit</button>
            </div>

            <div class="charts">
                <h2>Monthly Expense Chart</h2>
                <div class="chart-container">
                    <canvas id="monthlyExpenseChart"></canvas>
                </div>
                <h2>Category-wise Breakdown</h2>
                <div class="chart-container">
                    <canvas id="categoryBreakdownChart"></canvas>
                </div>
                <h2>Income vs. Expenses</h2>
                <div class="chart-container">
                    <canvas id="incomeVsExpensesChart"></canvas>
                </div>
            </div>

            <div id="transactions"></div>



            
        </div>

    )
}