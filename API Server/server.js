const express = require('express');
const app = express();
const PORT = 3000;

app.use(express.json());

app.get('/consultar', (req, res) => {
  const { username } = req.body;
  
  if (!username) {
    return res.status(400).json({ error: 'Todos os campos são obrigatorios' });
  }
  else if (username != "testuser") {
    return res.status(400).json({ error: 'Usuario não encontrado' });
  } else {
    res.status(200).json({ username: 'testuser', nome: 'teste usuario', desc: 'usuario criado para teste' });
  }
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
  const { username, password, confirmpassword } = req.body;

  if (!username || !password || !confirmpassword) {
    return res.status(400).json({ error: 'Todos os campos são obrigatorios' });
  }
  else if (password.length < 6) {
    return res.status(400).json({ error: 'Password precisa ser maior que 6 caracters' });
  }
  else if (username.length > 10) {
    return res.status(400).json({ error: 'Campo usuario com mais de 10 caracteres' });
  }
  else if(password != confirmpassword){
    return res.status(400).json({ error: 'Passwords não são iguais' });
  }
  else {
    res.status(200).json({ success: true, message: 'Usuario cadastrado com sucesso' });
  }
});

app.put('/changePassword', (req, res) => {
  const { oldpassword, newpassword, newconfirmpassword } = req.body;

  if (!oldpassword || !newpassword || !newconfirmpassword) {
    return res.status(400).json({ error: 'Todos os campos são obrigatorios' });
  }
  else if (oldpassword != "123456") {
    return res.status(400).json({ error: 'Password incorreto' });
  }
  else if (newpassword.length < 6) {
    return res.status(400).json({ error: 'Password precisa ser maior que 6 caracters' });
  }
  else if(newpassword != newconfirmpassword){
    return res.status(400).json({ error: 'Passwords não são iguais' });
  }
  else {
    res.status(200).json({ success: true, message: 'Password alterado com sucesso' });
  }
});

app.delete('/delete', (req, res) => {
  const { username } = req.body;

  if (!username) {
    return res.status(400).json({ error: 'Todos os campos são obrigatorios' });
  }
  else if (username != "testuser") {
    return res.status(400).json({ error: 'Usuario incorreto' });
  }
  else {
    res.status(200).json({ success: true, message: 'Password alterado com sucesso' });
  }
});

app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});
