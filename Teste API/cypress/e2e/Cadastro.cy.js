describe('Validação Cadastro com falha password com menos de 6 caracteres', () => {
  it('devera retornar post com status 400 e mensagem de erro', () => {
    cy.request({
      method: 'POST',
      url: 'http://localhost:3000/register',
      body: {
        username: 'testuser',
        password: '1234',
        confirmpassword: '1234'
      },
      failOnStatusCode: false
    }).then((response) => {
        expect(response.status).to.eq(400)
        expect(response.headers['content-type']).to.include('application/json')
        expect(response.body).to.have.property('error', 'Password precisa ser maior que 6 caracters')
        expect(response.body).to.have.all.keys('error')
      })
  })
}),

describe('Validação Cadastro com falha campos em branco', () => {
  it('devera retornar post com status 400 e mensagem de erro', () => {
    cy.request({
      method: 'POST',
      url: 'http://localhost:3000/register',
      body: {
        username: '',
        password: '',
        confirmpassword: ''
      },
      failOnStatusCode: false
    }).then((response) => {
        expect(response.status).to.eq(400)
        expect(response.headers['content-type']).to.include('application/json')
        expect(response.body).to.have.property('error', 'Todos os campos são obrigatorios')
        expect(response.body).to.have.all.keys('error')
      })
  })
}),

describe('Validação Cadastro com falha usuario com mais de 10 caracteres', () => {
  it('devera retornar post com status 400 e mensagem de erro', () => {
    cy.request({
      method: 'POST',
      url: 'http://localhost:3000/register',
      body: {
        username: 'tedsstuser56556666',
        password: '123456',
        confirmpassword: '123456'
      },
      failOnStatusCode: false
    }).then((response) => {
        expect(response.status).to.eq(400)
        expect(response.headers['content-type']).to.include('application/json')
        expect(response.body).to.have.property('error', 'Campo usuario com mais de 10 caracteres')
        expect(response.body).to.have.all.keys('error')
      })
  })
}),

describe('Validação Cadastro com falha confirmacao de password diferente', () => {
  it('devera retornar post com status 400 e mensagem de erro', () => {
    cy.request({
      method: 'POST',
      url: 'http://localhost:3000/register',
      body: {
        username: 'tedsstuser',
        password: '123456',
        confirmpassword: '123457'
      },
      failOnStatusCode: false
    }).then((response) => {
        expect(response.status).to.eq(400)
        expect(response.headers['content-type']).to.include('application/json')
        expect(response.body).to.have.property('error', 'Passwords não são iguais')
        expect(response.body).to.have.all.keys('error')
      })
  })
}),

describe('Validação Cadastro com sucesso', () => {
  it('devera retornar post com status 200 e mensagem de sucesso', () => {
    cy.request({
      method: 'POST',
      url: 'http://localhost:3000/register',
      body: {
        username: 'tedsstuser',
        password: '123456',
        confirmpassword: '123456'
      }
    }).then((response) => {
        expect(response.status).to.eq(200)
        expect(response.headers['content-type']).to.include('application/json')
        expect(response.body).to.have.property('message', 'Usuario cadastrado com sucesso')
        expect(response.body).to.have.all.keys('success', 'message')
      })
  })
})