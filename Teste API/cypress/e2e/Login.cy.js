describe('Validação Login com sucesso', () => {
  it('devera retornar post com status 200 token do usuario', () => {
    cy.request({
      method: 'POST',
      url: 'http://localhost:3000/login',
      body: {
        username: 'testuser',
        password: '1234'
      }
    }).then((response) => {
        expect(response.status).to.eq(200)
        expect(response.headers['content-type']).to.include('application/json')
        expect(response.body).to.have.property('token', 'fake-jwt-token')
        expect(response.body).to.have.all.keys('success', 'token')
      })
  })
}),

describe('Validação Login com falha', () => {
  it('devera retornar post com status 401 e mensagem de invalid credentials', () => {
    cy.request({
      method: 'POST',
      url: 'http://localhost:3000/login',
      body: {
        username: 'testuser',
        password: '12345'
      },
      failOnStatusCode: false
    }).then((response) => {
        expect(response.status).to.eq(401)
        expect(response.headers['content-type']).to.include('application/json')
        expect(response.body).to.have.property('message', 'Invalid credentials')
        expect(response.body).to.have.all.keys('success', 'message')
      })
  })
})