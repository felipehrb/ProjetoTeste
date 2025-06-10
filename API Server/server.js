const express = require('express');
const app = express();
const PORT = 3000;

app.use(express.json());

app.get('/test-endpoint', (req, res) => {
  res.json({ message: 'API is working!' });
});

app.post('/login', (req, res) => {
  const { username, password } = req.body;
  
  if (username === 'testuser' && password === '1234') {
    res.status(200).json({ success: true, token: 'fake-jwt-token' });
  } else {
    res.status(401).json({ success: false, message: 'Invalid credentials' });
  }
});

app.post('/register', (req, res) => {
  const { username, password } = req.body;
  
  if (username === 'testuser' && password === '1234') {
    res.status(200).json({ success: true, token: 'fake-jwt-token' });
  } else {
    res.status(401).json({ success: false, message: 'Invalid credentials' });
  }
});

app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});
