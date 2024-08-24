package com.roms.authentication.repository;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.roms.authentication.entity.Caregiver;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {CaregiverRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.roms.authentication.entity"})
@DataJpaTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
class CaregiverRepositoryTest {
    @Autowired
    private CaregiverRepository caregiverRepository;

    /**
     * Method under test: {@link CaregiverRepository#findByCaregiverName(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindByCaregiverName() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement; SQL [n/a]; constraint ["PRIMARY KEY ON PUBLIC.CAREGIVER(CAREGIVER_ID) [1, 'Soham Sadhu', '9821345612']"; SQL statement:
        //   insert into caregiver (caregiver_name, phone, caregiver_id) values (?, ?, ?) [23505-200]]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement
        //       at com.sun.proxy.$Proxy115.findByCaregiverName(null)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:59)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:42)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:113)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:99)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:200)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:3297)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:3824)
        //       at org.hibernate.action.internal.EntityInsertAction.execute(EntityInsertAction.java:107)
        //       at org.hibernate.engine.spi.ActionQueue.executeActions(ActionQueue.java:604)
        //       at org.hibernate.engine.spi.ActionQueue.lambda$executeActions$1(ActionQueue.java:478)
        //       at java.util.LinkedHashMap.forEach(LinkedHashMap.java:684)
        //       at org.hibernate.engine.spi.ActionQueue.executeActions(ActionQueue.java:475)
        //       at org.hibernate.event.internal.AbstractFlushingEventListener.performExecutions(AbstractFlushingEventListener.java:345)
        //       at org.hibernate.event.internal.DefaultAutoFlushEventListener.onAutoFlush(DefaultAutoFlushEventListener.java:57)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:93)
        //       at org.hibernate.internal.SessionImpl.autoFlushIfRequired(SessionImpl.java:1327)
        //       at org.hibernate.internal.SessionImpl.list(SessionImpl.java:1407)
        //       at org.hibernate.query.internal.AbstractProducedQuery.doList(AbstractProducedQuery.java:1625)
        //       at org.hibernate.query.internal.AbstractProducedQuery.list(AbstractProducedQuery.java:1593)
        //       at org.hibernate.query.internal.AbstractProducedQuery.getSingleResult(AbstractProducedQuery.java:1641)
        //       at org.hibernate.query.criteria.internal.compile.CriteriaQueryTypeQueryAdapter.getSingleResult(CriteriaQueryTypeQueryAdapter.java:111)
        //       at com.sun.proxy.$Proxy115.findByCaregiverName(null)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Unique index or primary key violation: "PRIMARY KEY ON PUBLIC.CAREGIVER(CAREGIVER_ID) [1, 'Soham Sadhu', '9821345612']"; SQL statement:
        //   insert into caregiver (caregiver_name, phone, caregiver_id) values (?, ?, ?) [23505-200]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:459)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:429)
        //       at org.h2.message.DbException.get(DbException.java:205)
        //       at org.h2.message.DbException.get(DbException.java:181)
        //       at org.h2.mvstore.db.MVPrimaryIndex.add(MVPrimaryIndex.java:127)
        //       at org.h2.mvstore.db.MVTable.addRow(MVTable.java:531)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:195)
        //       at org.h2.command.dml.Insert.update(Insert.java:151)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:198)
        //       at org.h2.command.Command.executeUpdate(Command.java:251)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:191)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:152)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:3297)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:3824)
        //       at org.hibernate.action.internal.EntityInsertAction.execute(EntityInsertAction.java:107)
        //       at org.hibernate.engine.spi.ActionQueue.executeActions(ActionQueue.java:604)
        //       at org.hibernate.engine.spi.ActionQueue.lambda$executeActions$1(ActionQueue.java:478)
        //       at java.util.LinkedHashMap.forEach(LinkedHashMap.java:684)
        //       at org.hibernate.engine.spi.ActionQueue.executeActions(ActionQueue.java:475)
        //       at org.hibernate.event.internal.AbstractFlushingEventListener.performExecutions(AbstractFlushingEventListener.java:345)
        //       at org.hibernate.event.internal.DefaultAutoFlushEventListener.onAutoFlush(DefaultAutoFlushEventListener.java:57)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:93)
        //       at org.hibernate.internal.SessionImpl.autoFlushIfRequired(SessionImpl.java:1327)
        //       at org.hibernate.internal.SessionImpl.list(SessionImpl.java:1407)
        //       at org.hibernate.query.internal.AbstractProducedQuery.doList(AbstractProducedQuery.java:1625)
        //       at org.hibernate.query.internal.AbstractProducedQuery.list(AbstractProducedQuery.java:1593)
        //       at org.hibernate.query.internal.AbstractProducedQuery.getSingleResult(AbstractProducedQuery.java:1641)
        //       at org.hibernate.query.criteria.internal.compile.CriteriaQueryTypeQueryAdapter.getSingleResult(CriteriaQueryTypeQueryAdapter.java:111)
        //       at com.sun.proxy.$Proxy115.findByCaregiverName(null)
        //   See https://diff.blue/R013 to resolve this issue.

        Caregiver caregiver = new Caregiver();
        caregiver.setCaregiverName("Caregiver Name");
        caregiver.setPhone("4105551212");

        Caregiver caregiver1 = new Caregiver();
        caregiver1.setCaregiverName("Caregiver Name");
        caregiver1.setPhone("4105551212");
        caregiverRepository.save(caregiver);
        caregiverRepository.save(caregiver1);
        caregiverRepository.findByCaregiverName("foo");
    }

    /**
     * Method under test: {@link CaregiverRepository#findByCaregiverNameIgnoreCase(String)}
     */
    @Test
    void testFindByCaregiverNameIgnoreCase() {
        Caregiver caregiver = new Caregiver();
        caregiver.setCaregiverName("Caregiver Name");
        caregiver.setPhone("4105551212");

        Caregiver caregiver1 = new Caregiver();
        caregiver1.setCaregiverName("Caregiver Name");
        caregiver1.setPhone("4105551212");
        caregiverRepository.save(caregiver);
        caregiverRepository.save(caregiver1);
        assertNull(caregiverRepository.findByCaregiverNameIgnoreCase("foo"));
    }
}

