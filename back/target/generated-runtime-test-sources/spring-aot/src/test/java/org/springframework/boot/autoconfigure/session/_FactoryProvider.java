package org.springframework.boot.autoconfigure.session;

public abstract class _FactoryProvider {
  public static JdbcIndexedSessionRepositoryDependsOnDatabaseInitializationDetector jdbcIndexedSessionRepositoryDependsOnDatabaseInitializationDetector(
      ) {
    return new JdbcIndexedSessionRepositoryDependsOnDatabaseInitializationDetector();
  }

  public static NonUniqueSessionRepositoryFailureAnalyzer nonUniqueSessionRepositoryFailureAnalyzer(
      ) {
    return new NonUniqueSessionRepositoryFailureAnalyzer();
  }
}
