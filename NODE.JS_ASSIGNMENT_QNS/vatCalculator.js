// vatCalculator.js

// Default VAT percentage is 3%
function calculateVAT(price, vatPercent = 3) {
  const vat = (price * vatPercent) / 100;
  const totalPrice = price + vat;
  return {
    vat,
    totalPrice
  };
}

module.exports = {
  calculateVAT
};
