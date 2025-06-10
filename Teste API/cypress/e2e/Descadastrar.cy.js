describe('Validação Troca de senha com falha password incorreto', () => {
  it('devera retornar post com status 400 e mensagem de erro', () => {
    cy.request({
      method: 'DELETE',
      url: 'http://localhost:3000/delete',
      body: {
        username: "testuser45"
      },
      failOnStatusCode: false
    }).then((response) => {
        expect(response.status).to.eq(400)
        expect(response.headers['content-type']).to.include('application/json')
        expect(response.body).to.have.property('error', 'Usuario incorreto')
        expect(response.body).to.have.all.keys('error')
      })
  })
}),

describe('Validação Descadastrar com sucesso', () => {
  it('devera retornar post com status 200 e mensagem de sucesso', () => {
    cy.request({
      method: 'DELETE',
      url: 'http://localhost:3000/delete',
      body: {
        username: "testuser"
      },
    }).then((response) => {
        expect(response.status).to.eq(200)
        expect(response.headers['content-type']).to.include('application/json')
        expect(response.body).to.have.property('message', 'Password alterado com sucesso')
        expect(response.body).to.have.all.keys('success', 'message')
      })
  })
})