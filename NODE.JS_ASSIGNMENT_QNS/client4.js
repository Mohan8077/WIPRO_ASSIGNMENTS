// client.js
const net = require('net');
const readline = require('readline');

const PORT = 5000;
const client = new net.Socket();

// Interface to read user input from terminal
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// Connect to the server
client.connect(PORT, '127.0.0.1', () => {
  console.log('Connected to Jewellery Store Server');
});

// Listen to server responses
client.on('data', (data) => {
  console.log(data.toString());
});

// Handle connection close
client.on('close', () => {
  console.log('Connection closed.');
  process.exit(0);
});

// Handle errors
client.on('error', (err) => {
  console.error('Connection Error:', err.message);
});

// Read and send user commands
rl.on('line', (input) => {
  client.write(input);
});
