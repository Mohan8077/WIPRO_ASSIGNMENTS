// server.js
const net = require('net');

const PORT = 5000;
let jewelleryStock = [
  { id: 1, name: 'Gold Ring', quantity: 5, price: 15000 },
  { id: 2, name: 'Silver Necklace', quantity: 3, price: 5000 }
];

const server = net.createServer((socket) => {
  console.log('Client connected.');

  socket.write('Welcome to the Jewellery Store Stock System.\n');

  socket.on('data', (data) => {
    const message = data.toString().trim();
    const parts = message.split(' ');

    if (message === 'LIST') {
      let response = '';
      jewelleryStock.forEach(item => {
        response += `ID: ${item.id}, Name: ${item.name}, Quantity: ${item.quantity}, Price: ${item.price}\n`;
      });
      socket.write(response || 'No items in stock.\n');
    }

    else if (parts[0] === 'ADD') {
      if (parts.length < 5) {
        socket.write('Invalid ADD command. Format: ADD <id> <name> <quantity> <price>\n');
        return;
      }
      const id = parseInt(parts[1]);
      const name = parts[2];
      const quantity = parseInt(parts[3]);
      const price = parseFloat(parts[4]);

      if (isNaN(id) || isNaN(quantity) || isNaN(price)) {
        socket.write('Invalid data types in ADD command.\n');
        return;
      }

      jewelleryStock.push({ id, name, quantity, price });
      socket.write('Jewellery item added successfully!\n');
      console.log(`Item Added - ID: ${id}, Name: ${name}, Quantity: ${quantity}, Price: ${price}`);
    }

    else if (message === 'EXIT') {
      socket.write('Client disconnected.\n');
      socket.end();
    }

    else {
      socket.write('Unknown command. Use LIST, ADD, or EXIT.\n');
    }
  });

  socket.on('end', () => {
    console.log('Client disconnected.');
  });

  socket.on('error', (err) => {
    console.error('Socket Error:', err.message);
  });
});

server.listen(PORT, () => {
  console.log(`TCP server running on port ${PORT}`);
});
