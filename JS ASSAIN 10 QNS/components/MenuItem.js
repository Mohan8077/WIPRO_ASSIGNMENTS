import React, { Component } from 'react';

class MenuItem extends Component {
  render() {
    const { name, price, category, available } = this.props;
    return (
      <li>
        {name} – ₹{price} ({category}), {available}
      </li>
    );
  }
}

export default MenuItem;
