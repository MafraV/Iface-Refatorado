- **Funcionalidades**:
  - **Criação de Conta (Sign up)**: O sistema pede para o usuário entrar seu nome, a senha da sua nova conta e seu nick name (apelido), assim registrando a nova conta criada no sistema.
  Nesta funcionalidade, resolvi ultilizar a coleção "Map" para armazenar as contas criadas, pois cada conta é única, e esta coleção não permite que sejam adicionador dois objetos com a mesma chave. 
  Ultilizando o apelido como a chave e a conta (classe Account) como conteúdo, já que duas pessoas podem ter o mesmo nome, porém o sistema não permite que sejam repetidos apelidos, portanto, ultilizar o apelido como chave foi a melhor escolha.
  Foram ultilizados os metodos: readInteger(), addAccount() e getNick();
  
  - **Fazer Login (Sign in)**: O sistema pede para o usuário entrar seu apelido e senha, caso a conta exista e as informação passadas estejam corretas, o sistema irá fazer login na conta, abrindo assim o menu onde todas as outras funcionalidades são apresentadas ao usuario.
  Nesta funcionalidade, o sistema faz a busca do apelido no Map onde são armazenadas as contas criadas, já que o apelido é ultilizado como chave. Caso o apelido não seja encontrado, o sistema informa o usuario através de uma mensagem. Caso o apelido seja encontrado, o sistema checa se a senha fornecida é igual a da conta encontrada com o apelido, caso as senhas não sejam iguais, o sistema informa ao usuario através de uma mensagem, caso as senhas sejam iguais, o login é efetuado.
  Todas as proximas funcionalidades do sistema exigem que o usuario esteja loggado em sua conta.
  Foram ultilizados os metodos: readInteger(), login(), getNick() e getPassword();
  
  - **Edição de Perfil**: O sistema pede para o usuário escolher qual atributo ele quer alterar: nome, senha ou apelido.
  Após informado, o sistema irá perguntar a nova informação, assim fazendo a alteração na conta.
  Foram ultilizados os metodos: readInteger(), login(), setName(), setPassword() e setNick();
  
  - **Adição de Amigos**: O sistema pede para o usuário entrar o apelido de seu possivel amigo, caso o apelido não exista, o apelido for de algum usuario ja registrado como amigo ou uma solicitação já tenha sido enviada anteriormente para este mesmo usuatio, o sistema informa o usuario atraves de uma mensagem, caso contrario, uma solicitação de amizade é enviada para o outro usuario.
  Caso ele aceite, um é adicionado na lista de amigos do outro, assim podendo trocar mensagens entre si, caso contrario, a solicitação é descartada e nada acontece.
  Nesta funcionalidade, resolvi ultilizar um Map para a lista da amigos, já que cada conta é única e cada apelido também, já as solicitações de amizades são guardadas em um ArrayList do tipo String, onde contém o apelido de cada usuario que enviou solicitação de amizade. Resolvi ultilizar um ArrayList pois a informação que deveria ser guardada é simples e como podem se acumular varias solicitações, o ArrayList me permite percorrer todas elas apenas através dos indices, o que facilita bastante.
  Foram ultilizados os metodos: readInteger(), login(), haveRequested(), addRequest(), getRequests(), addFriend();
  
  - **Envio de Mensagens**: Esta funcionalidade exige que os usuarios sejam amigos para ter acesso ao envio de mensagens. O sistema pede para o usuario entrar o apelido de seu amigo, caso a conta não exista ou os usuarios não sejam amigos, o sistema informa o usuario através de uma mensagem.
  Caso sejam amigos, o sistema pede para o usuario escrever a mensagem, assim enviando ela para o destinatario.
  Nesta funcionalidade, resolvi criar uma nova classe "Message", que contém o apelido de quem enviou a mensagem, o apelido de quem recebeu e o conteúdo da mensagem. Ultilizei um ArrayList para armazenar as messagens em cada conta, pelo mesmo motivo dito anteriormente sobre as solicitações de amizade. Cada mensagem tem uma flag "Read" que indica se o usuario leu ou não aquela mensagem, assim permitindo que eu navegue atravez do Array pelo indice e não sendo necessario a exclusão da mensagem, pois a flag é checada antes de apresentar a mensagem para o usuario.
  Foram ultilizados os metodos: readInteger(), login(), haveFriend(), addMessage(), checkMessages() e getRead();
  
  - **Criação de Comunidade**: O sistema pede para o usuario informar o nome de sua nova comunidade, caso o nome já esteja sendo ultilizado, o sistema informa o usuario através de uma mensagem, caso contrário, é pedido também para o usuario entrar a descrição da comunidade.
  Nesta funcionalidade, resolvi criar uma nova classe "Community", que contém o nome da comunidade, sua descrição, o apelido do criador e seus membros. Ultilizei um Map para armazer as comunidades criadas, pois cada comunidade é única, ultilizando o nome da comunidade como chave.
  Uma comunidade so pode ser gerenciada pelo seu criador, onde ele pode adicionar membros, remover membros, checar por solicitações de entrada e checar os membros daquela comunidade.
  Foram ultilizados os metodos: readInteger(), login() e addCommunity();
  
  - **Adição de Membro**: Para se tornar membro de uma comunidade, o dono da comunidade deve adicionar o usuario, ou o proprio usuario pode enviar uma solicitação de ingresso para o dono.
  Para o dono adicionar um membro, o sistema pede para ele informar o nome de sua comunidade, caso ela não exista ou o usuario não seja o dono dela, o sistema informa através de uma mensagem, caso contrário, um novo menu é apresentado ao usuário, onde uma das opções é a de adicionar um membro a comunidade.
  Após esta opção ser escolhida, o sistema pede para o usuario entrar o apelido da pessoa a ser adicionada, caso ela não exista ou ja seja membro da comunidade, o sistema informa através de uma mensagem.
  Caso contrário, o sistema adiciona o membro a comunidade, que fica armazenado em um Map, pois cada membro é único, ultilizando o apelido como chave.
  Foram ultilizados os metodos: readInteger(), login(), getOwnerNick(), addMember(), checkRequests() e addRequest();
  
  - **Recuperar Informações sobre a conta**: O sistema informa ao usuario todas as informações sobre sua conta, seu nome, sua senha, seu apelido, uma lista de todos seus amigos, suas mensagens e comunidades.
  Nesta funcionalidade, era necessário percorrer alguns Maps, como o de amigos e comunidades, para isso eu ultilizei um metodo da propria coleção Map, o keySet(), que faz um "Set" com todas as chaves do Map, o que convém muito a esta situação, pois as chaves sao nomes das comunidades e apelidos dos amigos.
  Esta funcionalidade foi dividida em algumas sub-funcionalidades, sendo elas: Verify Account information, Verify friend list, Verify message list e Verify community list.
  Foram ultilizados os metodos: readInteger(), login(), printInfo(), printFriends(), printMessages() e printCommunitys().
  
  - **Remoção de Conta**: O sistema remove a conta do usuario do Map de contas registradas, da lista de amizades dos seus amigos e da lista de membros das comunidades que ele faz parte.
  Como todos os locais de remoção foram feitos com Maps, a remoção é muito simples, apenas ultilizar os metodos da propria coleção, o remove.
  Para remover das listas de amizades e de membros, primeiro eu ultilizei o setKey dos Maps, então transformando em um array através do metodo toArray, assim gerando um array com todas as chaves dos Maps, permitindo que eu percorra este array pelo indice e pegando a conta/comunidade pelo metodo get do proprio Map.
  Desta maneira, foi possivel percorrer cada comunidade e cada amigo da conta em questão e remove-la.
  Foram ultilizados os metodos: readInteger(), login(), removeFromCommunitys() e removeFriends;
  

- **Classes**:
  
  - **Iface**:
    - Motivação: Era necessária a criação de uma classe que fosse uma espécie de central do programa, ela representaria o próprio sistema em funcionamento.
    - Solução: Foi criada então a classe "Iface", que contém tudo que era necessário de armazenamento, como contas e comunidades, além de conter o método login(), que é basicamente o corpo do programa.
    - Vantagens: Esta classe foi basicamente o que perminitiu o programa ser feito, pois ela é essencialmente a base de todo o resto.
    - Desvantagens: Por conter o método login(), acabou que ela ficou muito extensa e cheia de informações, o que pode acabar confundindo quem vê o código pela primeira vez.
    
  - **Account**: 
    - Motivação: Era necessária a criação de uma classe que representasse a conta do usuário, onde seriam armazenadas todas suas informações e onde ele poderia ter acesso as fundionalidades do sistema.
    - Solução: Foi criada então  a classe "Account", que contém todas as informações do usuário, nome, senha, apelido, amigos, comunidades e mensagens, além de permitir que a função login() seja chamada, sendo assim craido um Objeto da classe Account onde o usuário pode usufruir das funcionalidades do sistema.
    - Vantagens: Esta é outra classe essencial para o programa ser feito, pois é aqui onde ficam armazenadas a maioria das informações que são ultilizadas nas funcionalidades pedidas.
    - Desvantagens: No meu ver, não existe nenhuma desvantagem na criação desta classe.
    
  - **Community**:
    - Motivação: Era necessária a criação de uma classe que representasse as comunidades da rede social, onde seriam armazedos os membros da comunidade, o dono dela, o seu nome e descrição.
    - Solução: Foi criada então a classe "Community", que contém todas as informações sobre a comunidade, além de permitir que o dono da comunidade possa fazer operações nela, como adicionar membros, remover membros, etc.
    - Vantagens: Esta classe é extremamente necessária para o programa ser feito com todas as funcionalidades que foram pedidas.
    - Desvantagens: Talvez pudesse ser adicionadas mais informações a esta classe, permitindo assim que o dono e os membros pudessem ter mais funcionalidade nela, como enviar mensagens, apagar a comunidade, etc.
    
  - **Message**:
    - Motivação: Era necessário criar um sistema de troca de mensagens entre amigos.
    - Solução: Eu tinha duas opções para resolver este problema: Poderia criar um ArrayList do tipo String e armazenar a mensagem em si apenas ou criar uma classe nova "Message".
    Como é pedido que seja apresentado um histórico de mensagens, eu não poderia apenas mostrar a mensagem na tela para o usuário, percorrendo o ArrayList, e após isso remove-la, era necessario deixar ela armazenada, foi por isso que criei a classe "Message",
    onde o principal motivo dela ter sido criada é a flag "Read", que indica se a mensagem ja foi lida ou não pelo usuário, desta maneira, eu poderia mostrar a mensagem para o usuário quando ela fosse nova e não precisar remove-la do ArrayList, pois apenas as mensagens onde a flag = false são mostradas,
    dessa maneira, foi permitido mostrar o histórico de mensagens.
    - Vantagens: A principal vantagem da criação desta classe foi citada acima, poder mostrar a mensagem ao usuário quando ela for nova e poder apresentar um histórico geral de mensagens ultilizando apenas um ArrayList.
    - Desvantagens: Ela não tem muitos metodos, no geral apenas os gets e sets, o que me faz pensar que ela é uma classe dispensável, porém foi a melhor solução que eu encontrei quando me deparei com o problema citado acima.
    
    
- **Distribuição dos Métodos**:

  - **Iface**:
    - addAccount(): Este é o metodo que cria uma nova conta, ele foi colocado nesta classe foi é aqui onde esta o Map que contém todas as contas criadas.
    - readInteger(): Este é o metodo ultilizado no tratamento de exceções, específicamente a do tipo NumberFormatException. Foi colocado nesta classe pois é nesta que é feita a maioria das leituras de inteiros.
    - login(): Este é basicament o método principal do programa, pois é nele que estão contidos praticamente todas as funcionalidades do sistema, ele foi colocado nesta classe pois em munitas destas funcionalidades é necessário acessar uma conta, uma comunidade, etc. Que estão todas armazenadas nesta classe.
    
  - **Account**:
    - addFriend(): Este é o metodo que adiciona uma conta a lista de amigos do usuário, foi colocado nesta classe pois adiciona um Objeto ao Map amigos, que esta localizado nesta classe.
    - addMessage(): Este é o metodo que adiciona uma nova mensagem a lista de mensagens do usuário, foi colocado nesta classe pois adiciona um Objeto ao ArrayList mensagens, que esta localizado nesta classe.
    - addCommunity(): Mesma coisa dos anteriores, porém adiciona uma comunidade ao Map comunidades do usuário.
    - removeFriends(): Este é o metodo que remove a conta do usuário de todas as listas de amizades do seus amigos, no momento de deletar a conta, foi posta nesta classe pois é necessário o acesso ao Map amigos, que esta contigo nesta classe.
  
  - **Community**:
    - checkRequests(): Este é o metodo que permite o dono da comunidade aceitar ou não os usuários que enviaram solicitação de ingresso em sua comunidades, foi posto aqui pois é necessario o acesso ao ArrayList solicitações de entrada, que esta contido nesta classe.
  
  - **Message**:
    - read(): Este é o metodo que seta a flag "Read" para true, o que indica que a mensagem foi lida pelo usuário.


- **Tratamento de Exceções**:

  - **Motivação**: Era necessária a criação de um mecânismo para fazer com que os erros apresentados durante a execução do sistema fossem mais amistosas ao usuário,
  neste caso, o erro mais comum é o sistema pedir para o usuário entrar um inteiro e ele digitar algo diferente, como uma String ou um caracter,
  assim aparecendo uma mensagem gigante em vermelho que o usuário comum não intenderia.
  - **Solução**: Foi criada então o metodo readInteger(), onde caso o usuário entrasse algum tipo diferente além do inteiro, esta mensagem aparecia na tela: Input isn't a Integer! Please, try again:,
  que é algo muito mais amistoso e de fácil entendimento do usuário.
  Também foram feitas varias verificações sobre duplicatas ou não existencia, como por exemplo quando se tentava criar uma conta com um apelido ja existente, ou adicionar um amigo onde o apelido não existe, entre varios outros casos,
  em todos esses, uma mensagem de fácil entendimento é apresentada ao usuário.
  - **Vantagens**: Permite que o usuário mais leigo consiga entender o que de errado esta acontecendo quando a mensagem de erro aparece, também melhorando a experiencia de uso, transformando o sistema em um ambiente mais agradável.
  - **Desvantagens**: Ao meu ver, não existe nenhuma desvantagem no tratamento de exceções, pois é algo completamente necessário.
    
  
- **Reuso**:
  - **Motivação**: É sempre interessante evitar trechos de códigos repetidos, por isso a criação de alguns metodos que podem ser ultilizados em diversas classes é algo muito válido e proveitoso para a manuntenção do programa.
  - **Solução**: Neste programa, o maior caso de reusabilidade foi o método readInteger(), que é ultilizado no tratamento de exceções e lê o primeiro inteiro digitado pelo usuário.
  Este método é ultilizado em 3 classes diferentes, sendo elas: Main, Iface e Community. 
  Ele também é chamado por 2 métodos diferentes, sendo eles: login() e checkRequests(), sendo referenciado num total de 6 vezes.
  - **Vantagens**: Por se tratar de um tratamento de exceção, existe o try e o catch em sua composição, que consome muito espaço e muitas linhas, principalmente se for repetido todo o código as 6 vezes que ele se faz necessário,
  portanto é um método que melhora a eficiencia do programa, além de melhorar a manuntenção.
  - **Desvantagens**: Ao meu ver, não existe nenhuma desvantagem no reuso de métodos, pois é algo que facilita sua manuntenção e melhora seu desempenho.


