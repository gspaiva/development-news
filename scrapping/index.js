const cheerio = require('cheerio');
const request = require('request-promise');

const url = 'https://www.infoq.com/br/java/news';
const baseUrl = 'http://localhost:8080';

const parseBody = (body) => {
    const $  = cheerio.load(body);
    const data = [];
    $(".card__data").each((i,element) => {
        if(i > 5){
            const cardData = cheerio.load(element);
            let title = cardData(".card__title > a").text().replace(/\n/g,'').trim();   
            let url = 'https://www.infoq.com' + cardData(".card__title > a").attr('href');
            let description = cardData(".card__excerpt").text().replace(/\n/g,'').trim();
            let authorName = cardData(".card__authors > span > a").text();
            data.push({title, url, description, authorName});
        }
        
    });
    return data;
}

const getData = (url) => {
    return request(url)
    .then((body) => {
        return parseBody(body);
    })
    ;
}

const saveData = (data) => {

    const options = {
        method:'post',
        url:`${baseUrl}/news/v1`, 
        body: data, 
        headers: {"Content-type" : "application/json"},
        json: true
    };

    return request(options);

}

const data = getData(url);


const handler = function (event, context, callback) {
    data
    .then(data => {
        return saveData(data);
    })
    .then((response) => {
        callback(null, response);
    });
};

exports.handler = handler;

