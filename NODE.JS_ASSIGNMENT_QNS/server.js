// server.js
const express = require('express');
const bodyParser = require('body-parser');
const path = require('path');

const app = express();
const port = 3000;

// Middleware
app.use(bodyParser.urlencoded({ extended: true }));

// Serve the HTML form
app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'index.html'));
});

// Handle form submission
app.post('/submit', (req, res) => {
  const {
    trackingId,
    senderName,
    receiverName,
    pickupAddress,
    deliveryAddress,
    weight
  } = req.body;

  // Validation
  if (!trackingId || !senderName || !receiverName || !pickupAddress || !deliveryAddress || !weight) {
    return res.send('Error: All fields are required!');
  }

  const weightNumber = parseFloat(weight);
  if (isNaN(weightNumber) || weightNumber <= 0) {
    return res.send('Error: Invalid weight.');
  }

  // Calculate delivery cost
  const cost = 50 + (weightNumber * 20);

  // Confirmation message
  res.send(`
    <h2>Courier Booking Confirmation</h2>
    <p><strong>Courier Tracking ID:</strong> ${trackingId}</p>
    <p><strong>Sender:</strong> ${senderName}</p>
    <p><strong>Receiver:</strong> ${receiverName}</p>
    <p><strong>Pickup:</strong> ${pickupAddress}</p>
    <p><strong>Delivery:</strong> ${deliveryAddress}</p>
    <p><strong>Weight:</strong> ${weightNumber} kg</p>
    <p><strong>Delivery Cost:</strong> ₹${cost}</p>
  `);
});

// Start server
app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}`);
});
