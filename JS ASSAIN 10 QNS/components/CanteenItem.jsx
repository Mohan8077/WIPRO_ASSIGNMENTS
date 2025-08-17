import React from 'react';

const CanteenItem = ({ name, price, category, available }) => {
  return (
    <li>
      <strong>{name}</strong> – Price: ₹{price} – Category: {category} – Available: {available}
    </li>
  );
};

export default CanteenItem;
