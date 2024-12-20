```java
/PROYECT
└─ /COMMON
|     └─ /annotation
|     |     └─ Dao.java
|     |     └─ DomainService.java
|     |     └─ DomainTransactional.java
|     |     └─ DomainUseCase.java
|     └─ /exception
|     |     └─ ResourceAlreadyExistsException.java
|     |     └─ ResourceNotFoundException.java
|     └─ /locale
|     |     └─ CustomLocaleChangeInterceptor.java
|     |     └─ LanguageUtils.java
|     |     └─ LocaleConfig.java
|     └─ /utils
|           └─ Color.java
|
└─ /PRESENTATION
|     └─ /controller
|     |     └─ MovieController.java
|     |     └─ ActorController.java
|     |     └─ DirectorController.java
|     └─ /mapper
|     |     └─ MovieWebMapper.java
|     |     └─ ActorWebMapper.java
|     |     └─ DirectorWebMapper.java
|     └─ /model
|           └─ MovieWebModel.java
|           └─ ActorWebModel.java
|           └─ DirectorWebModel.java
|
└─ /DOMAIN
|     └─ /usecase
|     |     └─ /interfaces
|     |     |     └─ MovieFindByIdUseCase.java
|     |     |     └─ MovieFindAllUseCase.java
|     |     |     └─ MovieCreateUseCase.java
|     |     |     └─ MovieUpdateUseCase.java
|     |     |     └─ MovieDeleteUseCase.java
|     |     └─ /impl
|     |           └─ MovieFindByIdUseCaseImpl.java
|     |           └─ MovieFindAllUseCaseImpl.java
|     |           └─ MovieCreateUseCaseImpl.java
|     |           └─ MovieUpdateUseCaseImpl.java
|     |           └─ MovieDeleteUseCaseImpl.java
|     └─ /service
|     |     └─ /model
|     |     |     └─ Movie.java
|     |     |     └─ Actor.java
|     |     |     └─ Director.java
|     |     └─ /interfaces
|     |     |     └─ MovieService.java
|     |     |     └─ ActorService.java
|     |     |     └─ DirectorService.java
|     |     └─ /impl
|     |           └─ MovieServiceImpl.java
|     |           └─ ActorServiceImpl.java
|     |           └─ DirectorServiceImpl.java
|     └─ /repository
|           └─ MovieRepository.java
|           └─ ActorRepository.java
|           └─ DirectorRepository.java
|
└─ /PERSISTENCE
|     └─ /repositoryImpl
|     |     └─ MovieRepositoryImpl.java
|     |     └─ ActorRepositoryImpl.java
|     |     └─ DirectorRepositoryImpl.java
|     └─ /dao
|           └─ /interfaces
|           |     └─ MovieDao.java
|           |     └─ ActorDao.java
|           |     └─ DirectorDao.java
|           └─ /impl
|                 └─ MovieDaoImpl.java
|                 └─ ActorDaoImpl.java
|                 └─ DirectorDaoImpl.java
|                 |
|                 └─ /jpa
|                 |     └─ MovieJpa.java
|                 |     └─ ActorJpa.java
|                 |     └─ DirectorJpa.java
|                 └─ /mapper
|                 |     └─ MovieDaoMapper.java
|                 |     └─ ActorDaoMapper.java
|                 |     └─ DirectorDaoMapper.java
|                 └─ /model
|                       └─ MovieDaoModel.java
|                       └─ ActorDaoModel.java
|                       └─ DirectorDaoModel.java
|
└─ App.java
```