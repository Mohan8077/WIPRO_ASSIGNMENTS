const readline = require('readline');
const db = require('./mysqldbconnection');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

function showMenu() {
  console.log(`
Stock Market Management System
-------------------------------
1. Add Stock
2. View All Stocks
3. View Stock by ID
4. Update Stock Price & Volume
5. Delete Stock
6. Exit
`);
  rl.question('Enter your choice: ', handleChoice);
}

function handleChoice(choice) {
  switch (choice.trim()) {
    case '1':
      addStock();
      break;
    case '2':
      viewAllStocks();
      break;
    case '3':
      viewStockById();
      break;
    case '4':
      updateStock();
      break;
    case '5':
      deleteStock();
      break;
    case '6':
      exit();
      break;
    default:
      console.log('Invalid choice.\n');
      showMenu();
  }
}

// --- 1. Add Stock ---
function addStock() {
  rl.question('Enter Stock Symbol: ', symbol => {
    if (!symbol.trim()) return invalidInput('Symbol');

    rl.question('Enter Company Name: ', companyName => {
      if (!companyName.trim()) return invalidInput('Company Name');

      rl.question('Enter Price: ', price => {
        if (isNaN(price)) return invalidInput('Price');

        rl.question('Enter Volume: ', volume => {
          if (isNaN(volume)) return invalidInput('Volume');

          const sql = 'INSERT INTO stocks (symbol, companyName, price, volume) VALUES (?, ?, ?, ?)';
          db.query(sql, [symbol, companyName, parseFloat(price), parseInt(volume)], (err, result) => {
            if (err) throw err;
            console.log('Stock added successfully!\n');
            showMenu();
          });
        });
      });
    });
  });
}

// --- 2. View All Stocks ---
function viewAllStocks() {
  db.query('SELECT * FROM stocks', (err, results) => {
    if (err) throw err;
    console.table(results);
    showMenu();
  });
}

// --- 3. View Stock by ID ---
function viewStockById() {
  rl.question('Enter Stock ID: ', id => {
    if (isNaN(id)) return invalidInput('Stock ID');

    db.query('SELECT * FROM stocks WHERE id = ?', [parseInt(id)], (err, results) => {
      if (err) throw err;
      if (results.length === 0) {
        console.log('Stock not found.\n');
      } else {
        console.table(results);
      }
      showMenu();
    });
  });
}

// --- 4. Update Stock ---
function updateStock() {
  rl.question('Enter Stock ID to Update: ', id => {
    if (isNaN(id)) return invalidInput('Stock ID');

    rl.question('Enter New Price: ', price => {
      if (isNaN(price)) return invalidInput('Price');

      rl.question('Enter New Volume: ', volume => {
        if (isNaN(volume)) return invalidInput('Volume');

        const sql = 'UPDATE stocks SET price = ?, volume = ? WHERE id = ?';
        db.query(sql, [parseFloat(price), parseInt(volume), parseInt(id)], (err, result) => {
          if (err) throw err;
          if (result.affectedRows === 0) {
            console.log('No stock found with that ID.\n');
          } else {
            console.log('Stock updated successfully!\n');
          }
          showMenu();
        });
      });
    });
  });
}

// --- 5. Delete Stock ---
function deleteStock() {
  rl.question('Enter Stock ID to Delete: ', id => {
    if (isNaN(id)) return invalidInput('Stock ID');

    db.query('DELETE FROM stocks WHERE id = ?', [parseInt(id)], (err, result) => {
      if (err) throw err;
      if (result.affectedRows === 0) {
        console.log('No stock found with that ID.\n');
      } else {
        console.log('Stock deleted successfully!\n');
      }
      showMenu();
    });
  });
}

// --- 6. Exit ---
function exit() {
  console.log('Goodbye!');
  rl.close();
  db.end();
}

// --- Utility ---
function invalidInput(field) {
  console.log(`Invalid ${field}. Please try again.\n`);
  showMenu();
}

// Start the menu
showMenu();
