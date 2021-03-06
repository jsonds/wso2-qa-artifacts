Scenario
===========
In this scenario, DAS will be connected to a JMS event publisher such as ActiveMQ by subscribing to a topic ex: "test_topic". Once an event payload is received from ActiveMQ, those events are then sent  to inStream_1.0.0. The events will be then processed within the execution planner where all events are collected for a time of one minute and push out after the event expire. The out stream will then save the data to an rdbms database table.

Preconditions
=============
1.A Database should be created in mysql as below
create table tbldata(meta_id int(10),correlation_id int(20),id int(10), username varchar (200));

2.The Data Source should be configured within DAS

3.ActiveMQ should be running

4.ActiveMQ related Jars should be added to repository/components/lib path

steps
======
1.add the event streams inStream_1.0.0.json and outStream_1.0.0.json to path <das-home>/repository/deployment/server/eventstreams

2.add the event receiver ex: jms_event.xml to <das-home>/repository/deployment/server/eventreceiver

3.add the rdbms.xml to <das-home>/repository/deployment/server/eventpublisher

4.add the execution plan ExecutionPlan.siddhiql to <das-home>/repository/deployment/server/executionplans

5.Access the topic test_topic in ActiveMQ and Submit a payload

<events>
    <event>
        <metaData>
            <id>100</id>
        </metaData>
        <correlationData>
            <id>100</id>
        </correlationData>
        <payloadData>
            <id>45</id>
            <name>data3</name>
        </payloadData>
    </event>
</events>

6.check the db table for events for expired events.
