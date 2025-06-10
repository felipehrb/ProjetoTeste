describe('Validação Troca de senha com falha password incorreto', () => {
  it('devera retornar post com status 400 e mensagem de erro', () => {
    cy.request({
      method: 'PUT',
      url: 'http://localhost:3000/changePassword',
      body: {
        oldpassword: '123455',
        newpassword: '123457',
        newconfirmpassword: '123457'
      },
      failOnStatusCode: false
    }).then((response) => {
        expect(response.status).to.eq(400)
        expect(response.headers['content-type']).to.include('application/json')
        expect(response.body).to.have.property('error', 'Password incorreto')
        expect(response.body).to.have.all.keys('error')
      })
  })
}),

describe('Validação Troca de senha com falha password com menos de 6 caracteres', () => {
  it('devera retornar post com status 400 e mensagem de erro', () => {
    cy.request({
      method: 'PUT',
      url: 'http://localhost:3000/changePassword',
      body: {
        oldpassword: '123456',
        newpassword: '1234',
        newconfirmpassword: '1234'
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

describe('Validação Troca de senha com falha confirmacao de password diferente', () => {
  it('devera retornar post com status 400 e mensagem de erro', () => {
    cy.request({
      method: 'PUT',
      url: 'http://localhost:3000/changePassword',
      body: {
        oldpassword: '123456',
        newpassword: '123457',
        newconfirmpassword: '123458'
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

describe('Validação Troca de senha com sucesso', () => {
  it('devera retornar post com status 200 e mensagem de sucesso', () => {
    cy.request({
      method: 'PUT',
      url: 'http://localhost:3000/changePassword',
      body: {
        oldpassword: '123456',
        newpassword: '123457',
        newconfirmpassword: '123457'
      },
    }).then((response) => {
        expect(response.status).to.eq(200)
        expect(response.headers['content-type']).to.include('application/json')
        expect(response.body).to.have.property('message', 'Password alterado com sucesso')
        expect(response.body).to.have.all.keys('success', 'message')
      })
  })
})