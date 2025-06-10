describe('Validação Consultar com usuario incorreto', () => {
  it('devera retornar get com status 400 e mensagem de erro', () => {
    cy.request({
      method: 'GET',
      url: 'http://localhost:3000/consultar',
      body: {
        username: "testuser45"
      },
      failOnStatusCode: false
    }).then((response) => {
        expect(response.status).to.eq(400)
        expect(response.headers['content-type']).to.include('application/json')
        expect(response.body).to.have.property('error', 'Usuario não encontrado')
        expect(response.body).to.have.all.keys('error')
      })
  })
}),

describe('Validação Consultar com usuario em branco', () => {
  it('devera retornar get com status 400 e mensagem de erro', () => {
    cy.request({
      method: 'GET',
      url: 'http://localhost:3000/consultar',
      body: {
        username: ""
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

describe('Validação Consultar com sucesso', () => {
  it('devera retornar post com status 200 e informacoes do usuario', () => {
    cy.request({
      method: 'GET',
      url: 'http://localhost:3000/consultar',
      body: {
        username: "testuser"
      },
    }).then((response) => {
        expect(response.status).to.eq(200)
        expect(response.headers['content-type']).to.include('application/json')
        expect(response.body).to.have.property('username', 'testuser')
        expect(response.body).to.have.property('nome', 'teste usuario')
        expect(response.body).to.have.property('desc', 'usuario criado para teste')
        expect(response.body).to.have.all.keys('username', 'nome', 'desc')
      })
  })
})