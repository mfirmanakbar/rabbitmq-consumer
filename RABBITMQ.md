## RabbitMQ

1. Simple Queue
    - Go to Queues => Add Queue `testproducer.hello`
    - Let the other fields are default
    - Queues => Get Messages 
    
2. Scheduled Sample
    - Go to Queues
    - Add Queue `test.fixedrate`

3. Consuming JSON Format
    - Go to Queues 
    - Add Queue `test.employee`
    
4. Exchange FanOut Type
    - Go to Queues 
    - Add 2 Queues: 
        - `q.hr.accounting`
        - `q.hr.marketing`
    - Go to Exchanges 
    - Add Exchange `x.hr` and Add 2 Bindings on it:
        - `q.hr.accounting` 
        - `q.hr.marketing`

5. Exchange Direct Type
    - Go to Queues 
    - Add 2 Queues: 
        - `q.picture.image`
        - `q.picture.vector`
    - Go to Exchanges 
    - Add Exchange `x.picture` and Add 3 Bindings on it: 
        - `q.picture.image` with routing key `jpg`
        - `q.picture.image` with routing key `png`
        - `q.picture.vector` with routing key `svg`

6. Exchange Topic Type
    - Go to Queues 
    - Add 4 Queues: 
        - `q.picturetopic.filter`
        - `q.picturetopic.image`
        - `q.picturetopic.log`
        - `q.picturetopic.vector`
    - Go to Exchanges 
    - Add Exchange `x.picturetopic` and Add 5 Bindings on it:         
        - `q.picturetopic.filter` with routing key `mobile.#`
        - `q.picturetopic.image` with routing key `#.jpg`
        - `q.picturetopic.image` with routing key `*.*.png`
        - `q.picturetopic.log` with routing key `*.large.svg`
        - `q.picturetopic.vector` with routing key `*.*.svg`
