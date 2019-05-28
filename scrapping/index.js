const cheerio = require('cheerio');
const request = require('request-promise');

const url = 'https://www.infoq.com/br/java/news';


const parseBody = (body) => {
    const $  = cheerio.load(body);
    const data = [];
    $(".card__data").each((i,element) => {
        if(i > 5){
            const cardData = cheerio.load(element);
            let title = cardData(".card__title > a").text().replace(/\n/g,'').trim();   
            let link = 'https://www.infoq.com' + cardData(".card__title > a").attr('href');
            let description = cardData(".card__excerpt").text().replace(/\n/g,'').trim();
            let authors = cardData(".card__authors > span > a").text();
            data.push({title, link, description, authors});
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

const data = getData(url);

const handler = function (event, context, callback) {
    data.then(data => callback(null, data));
};

exports.handler = handler;

