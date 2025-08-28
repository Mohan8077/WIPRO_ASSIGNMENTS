// app.js

const { calculateVAT } = require('./vatCalculator');

// Array of jewellery items (Bonus Task)
const jewelleryItems = [
  { id: 1, name: "Gold Necklace", price: 50000 },
  { id: 2, name: "Silver Ring", price: 8000 },
  { id: 3, name: "Diamond Earrings", price: 120000 }
];

// VAT percentage (Bonus Task: configurable)
const vatPercent = 3;

// Display results
jewelleryItems.forEach(item => {
  const result = calculateVAT(item.price, vatPercent);
  console.log(`Jewellery ID: ${item.id}`);
  console.log(`Name: ${item.name}`);
  console.log(`Price: ${item.price}`);
  console.log(`VAT (${vatPercent}%): ${result.vat}`);
  console.log(`Total Price: ${result.totalPrice}`);
  console.log('---');
});
