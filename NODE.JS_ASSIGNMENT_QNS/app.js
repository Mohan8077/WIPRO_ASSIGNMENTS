// app.js
const connection = require('./mysqldbconnection');

// CREATE
function addStock(symbol, companyName, price, volume, callback) {
  const sql = 'INSERT INTO stocks (symbol, companyName, price, volume) VALUES (?, ?, ?, ?)';
  connection.query(sql, [symbol, companyName, price, volume], (err, result) => {
    if (err) return callback(err);
    console.log('Added stock with ID:', result.insertId);
    callback(null, result.insertId);
  });
}

// READ
function listStocks(callback) {
  connection.query('SELECT * FROM stocks', (err, results) => {
    if (err) return callback(err);
    console.log('All Stocks:', results);
    callback(null, results);
  });
}

// UPDATE
function updateStockPriceAndVolume(id, price, volume, callback) {
  const sql = 'UPDATE stocks SET price = ?, volume = ? WHERE id = ?';
  connection.query(sql, [price, volume, id], (err, result) => {
    if (err) return callback(err);
    console.log('Updated records:', result.affectedRows);
    callback(null, result.affectedRows);
  });
}

// DELETE
function deleteStock(id, callback) {
  connection.query('DELETE FROM stocks WHERE id = ?', [id], (err, result) => {
    if (err) return callback(err);
    console.log('Deleted records:', result.affectedRows);
    callback(null, result.affectedRows);
  });
}

// Sequential Execution
addStock('AAPL', 'Apple Inc.', 175.50, 1000, (err, insertedId) => {
  if (err) throw err;

  listStocks((err, stocks) => {
    if (err) throw err;

    updateStockPriceAndVolume(insertedId, 180.00, 1200, (err) => {
      if (err) throw err;

      deleteStock(insertedId, (err) => {
        if (err) throw err;

        connection.end(() => {
          console.log('MySQL connection closed');
        });
      });
    });
  });
});
