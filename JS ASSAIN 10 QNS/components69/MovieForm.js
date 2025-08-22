//  not yet donr
import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

class MovieForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      showForm: true,
      title: '',
      director: '',
      year: '',
      genre: 'Action',
      rating: '',
      description: '',
      platforms: {
        Netflix: false,
        'Amazon Prime': false,
        'Disney+': false,
        Others: false
      },
      movies: []
    };
    console.log('constructor executed');
  }

  static getDerivedStateFromProps(props, state) {
    console.log('getDerivedStateFromProps executed');
    return null; // no state update from props in this example
  }

  componentDidMount() {
    console.log('componentDidMount executed');
  }

  shouldComponentUpdate(nextProps, nextState) {
    console.log('shouldComponentUpdate executed');
    return true;
  }

  getSnapshotBeforeUpdate(prevProps, prevState) {
    console.log('getSnapshotBeforeUpdate executed');
    return null;
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
    console.log('componentDidUpdate executed');
  }

  componentWillUnmount() {
    console.log('componentWillUnmount executed');
  }

  handleChange = (e) => {
    const { name, value, type, checked } = e.target;

    if (type === 'checkbox') {
      this.setState((prevState) => ({
        platforms: {
          ...prevState.platforms,
          [name]: checked
        }
      }));
    } else {
      this.setState({ [name]: value });
    }
  };

  handleSubmit = (e) => {
    e.preventDefault();
    const { title, director, year, genre, rating, description, platforms } = this.state;

    const selectedPlatforms = Object.keys(platforms).filter((key) => platforms[key]);

    const newMovie = {
      title,
      director,
      year,
      genre,
      rating,
      description,
      platforms: selectedPlatforms
    };

    this.setState((prevState) => ({
      movies: [...prevState.movies, newMovie],
      title: '',
      director: '',
      year: '',
      genre: 'Action',
      rating: '',
      description: '',
      platforms: {
        Netflix: false,
        'Amazon Prime': false,
        'Disney+': false,
        Others: false
      }
    }));
  };

  toggleForm = () => {
    this.setState((prevState) => ({
      showForm: !prevState.showForm
    }));
  };

  render() {
    console.log('render executed');
    const { showForm, title, director, year, genre, rating, description, platforms, movies } = this.state;

    return (
      <div className="container my-4">
        <button className="btn btn-secondary mb-3" onClick={this.toggleForm}>
          {showForm ? 'Hide Form' : 'Show Form'}
        </button>

        {showForm && (
          <div className="card p-4">
            <h4 className="mb-3">Movie FORM</h4>
            <form onSubmit={this.handleSubmit}>
              <div className="mb-2">
                <label>Movie Title</label>
                <input type="text" name="title" className="form-control" value={title} onChange={this.handleChange} />
              </div>

              <div className="mb-2">
                <label>Director</label>
                <input type="text" name="director" className="form-control" value={director} onChange={this.handleChange} />
              </div>

              <div className="mb-2">
                <label>Release Year</label>
                <input type="number" name="year" className="form-control" value={year} onChange={this.handleChange} />
              </div>

              <div className="mb-2">
                <label>Genre</label>
                <select name="genre" className="form-control" value={genre} onChange={this.handleChange}>
                  <option>Action</option>
                  <option>Comedy</option>
                  <option>Drama</option>
                  <option>Sci-Fi</option>
                  <option>Horror</option>
                </select>
              </div>

              <div className="mb-2">
                <label>Rating</label>
                <div>
                  {[1, 2, 3, 4, 5].map((num) => (
                    <label className="me-3" key={num}>
                      <input
                        type="radio"
                        name="rating"
                        value={num}
                        checked={rating === String(num)}
                        onChange={this.handleChange}
                      />{' '}
                      {num}
                    </label>
                  ))}
                </div>
              </div>

              <div className="mb-2">
                <label>Description</label>
                <textarea name="description" className="form-control" value={description} onChange={this.handleChange} />
              </div>

              <div className="mb-3">
                <label>Available on Streaming Platforms</label>
                <div className="form-check">
                  {Object.keys(platforms).map((platform) => (
                    <label className="form-check-label me-3" key={platform}>
                      <input
                        type="checkbox"
                        name={platform}
                        checked={platforms[platform]}
                        onChange={this.handleChange}
                        className="form-check-input me-1"
                      />
                      {platform}
                    </label>
                  ))}
                </div>
              </div>

              <button className="btn btn-primary">Add Movie</button>
            </form>
          </div>
        )}

        {movies.length > 0 && (
          <table className="table mt-4">
            <thead>
              <tr>
                <th>Title</th>
                <th>Director</th>
                <th>Release Year</th>
                <th>Genre</th>
                <th>Rating</th>
                <th>Available on Streaming Platforms</th>
              </tr>
            </thead>
            <tbody>
              {movies.map((movie, idx) => (
                <tr key={idx}>
                  <td>{movie.title}</td>
                  <td>{movie.director}</td>
                  <td>{movie.year}</td>
                  <td>{movie.genre}</td>
                  <td>{movie.rating}</td>
                  <td>{movie.platforms.join(', ')}</td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    );
  }
}

export default MovieForm;
