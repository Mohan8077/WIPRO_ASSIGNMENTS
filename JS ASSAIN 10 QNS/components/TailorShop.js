import React, { useState } from 'react';

const tailoringItems = [
  { title: 'Shirt', price: 20, fabrics: ['Cotton', 'Linen', 'Polyester'] },
  { title: 'Pants', price: 30, fabrics: ['Denim', 'Wool', 'Chino'] },
  { title: 'Lehenga', price: 150, fabrics: ['Silk', 'Georgette', 'Chiffon'] },
  { title: 'Blouse', price: 40, fabrics: ['Cotton', 'Silk', 'Satin'] },
];

export default function TailoringServices() {
  const [selectedItem, setSelectedItem] = useState(null);

  return (
    <div className="container my-5">
      <h2 className="text-center mb-4">👗 Tailoring Services</h2>

      <div className="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-4">
        {tailoringItems.map((item, index) => (
          <div className="col" key={index}>
            <div className="card h-100 shadow-sm">
              <div className="card-body">
                <h5 className="card-title">{item.title}</h5>
                <h6 className="card-subtitle mb-2 text-muted">
                  Price: ₹{item.price}
                </h6>
                <button
                  className="btn btn-primary mt-2"
                  onClick={() => setSelectedItem(item)}
                  data-bs-toggle="modal"
                  data-bs-target="#itemModal"
                >
                  View Details
                </button>
              </div>
            </div>
          </div>
        ))}
      </div>

      {/* Bootstrap Modal */}
      <div
        className="modal fade"
        id="itemModal"
        tabIndex="-1"
        aria-hidden="true"
      >
        <div className="modal-dialog modal-dialog-centered">
          <div className="modal-content">
            {selectedItem && (
              <>
                <div className="modal-header">
                  <h5 className="modal-title">{selectedItem.title}</h5>
                  <button
                    type="button"
                    className="btn-close"
                    data-bs-dismiss="modal"
                    aria-label="Close"
                  ></button>
                </div>
                <div className="modal-body">
                  <p><strong>Price:</strong> ₹{selectedItem.price}</p>
                  <p><strong>Available Fabrics:</strong></p>
                  <ul>
                    {selectedItem.fabrics.map((fabric, i) => (
                      <li key={i}>{fabric}</li>
                    ))}
                  </ul>
                </div>
                <div className="modal-footer">
                  <button
                    type="button"
                    className="btn btn-secondary"
                    data-bs-dismiss="modal"
                  >
                    Close
                  </button>
                  <button type="button" className="btn btn-success">
                    Book Now
                  </button>
                </div>
              </>
            )}
          </div>
        </div>
      </div>
    </div>
  );
}
