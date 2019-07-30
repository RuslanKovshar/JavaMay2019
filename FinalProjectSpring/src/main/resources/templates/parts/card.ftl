<div class="card-body">
    <h5 class="card-title"><@spring.message "application"/> №{{$index + 1}}</h5>
    <div class="row">
        <div class="font-weight-bold mr-1"><@spring.message "actual.weight.message"/>:</div>
        <p class="card-text">{{r.application.weight}}</p>
    </div>
    <div class="row">
        <div class="font-weight-bold mr-1"><@spring.message "type.message"/>:</div>
        <p class="card-text">{{r.application.type}}</p>
    </div>
    <div class="row">
        <div class="font-weight-bold mr-1"><@spring.message "date.message"/>:</div>
        <p class="card-text">{{r.application.localDate}}</p>
    </div>
    <div class="row">
        <div class="font-weight-bold mr-1"><@spring.message "delivery.cost.message"/>:</div>
        <p class="card-text">{{r.cost}}</p>
    </div>
</div>