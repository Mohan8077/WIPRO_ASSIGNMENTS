import React from 'react';
import ReactDOM from 'react-dom/client';
import 'bootstrap/dist/css/bootstrap.min.css';   // ✅ Bootstrap CSS here
import 'bootstrap/dist/js/bootstrap.bundle.min.js'; // optional, for modals, dropdowns, tooltips
import App from './App';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);
