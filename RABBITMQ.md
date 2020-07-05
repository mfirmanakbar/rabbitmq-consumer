### RabbitMQ Steps to this Project

1. Simple Queue
    - Go to Queues 
    - Add Queue name `testproducer.hello`
    - Let the other fields are default 
    
2. Scheduled Sample
    - Go to Queues
    - Add Queue name `test.fixedrate`

3. Consuming JSON Format
    - Go to Queues 
    - Add Queue name `test.employee`
    
4. Exchange FanOut Type
    - Go to Queues 
    - Add 2 Queues: 
        - name `q.hr.accounting`
        - name `q.hr.marketing`
    - Go to Exchanges 
    - Add FanOut Exchange name `x.hr` and Add 2 Bindings on it:
        - name `q.hr.accounting` 
        - name `q.hr.marketing`

5. Exchange Direct Type
    - Go to Queues 
    - Add 2 Queues: 
        - name `q.picture.image`
        - name `q.picture.vector`
    - Go to Exchanges 
    - Add Direct Exchange name `x.picture` and Add 3 Bindings on it: 
        - name `q.picture.image` with routing key `jpg`
        - name `q.picture.image` with routing key `png`
        - name `q.picture.vector` with routing key `svg`

6. Exchange Topic Type
    - Go to Queues 
    - Add 4 Queues: 
        - name `q.picturetopic.filter`
        - name `q.picturetopic.image`
        - name `q.picturetopic.log`
        - name `q.picturetopic.vector`
    - Go to Exchanges 
    - Add Topic Exchange name `x.picturetopic` and Add 5 Bindings on it:         
        - name `q.picturetopic.filter` with routing key `mobile.#`
        - name `q.picturetopic.image` with routing key `#.jpg`
        - name `q.picturetopic.image` with routing key `*.*.png`
        - name `q.picturetopic.log` with routing key `*.large.svg`
        - name `q.picturetopic.vector` with routing key `*.*.svg`

7. Error Handling with DLX
    - Go to Exchanges 
    - Add FanOut Exchange (or other) with name `x.mypicture`    
    - Go to Exchanges 
        - Add FanOut Exchange (or other) with name `x.mypicture.dlx`
        - Go to Queues 
        - Add Queue:
            - name `q.mypicture.dlx` and click it
            - Then Bindings with `x.mypicture.dlx`
        - Add Queue:
            - name `q.mypicture.image`
            - Add the argument with:
                - `x-dead-letter-exchange` = `x.mypicture.dlx` String
                - or just click **Dead letter exchange** then equals `x.mypicture.dlx`
            - Click `q.mypicture.image` on Queues then Bindings with name `x.mypicture`
