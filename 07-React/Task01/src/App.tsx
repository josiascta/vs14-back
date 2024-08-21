import React from 'react';

import './App.css';

function App() {
  return (
    <div className="container">
      <nav className="navbar">
        <h1 className="nav-title">Meu site</h1>
        <ul className="nav-menu">
          <li className="nav-item">Home</li>
          <li className="nav-item">About</li>
          <li className="nav-item">Contact</li>
        </ul>
      </nav>
      <header className="header">
        <h2 className="header-text">Bem-vindo ao meu site feito com React!</h2>
      </header>
      <main className="main">
        <p className="main-text">Área do main</p>
      </main>
      <footer className="footer">
        <p className="footer-text">© 2024 Meu Site</p>
      </footer>
    </div>
  );
}

export default App;
