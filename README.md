# Locus-Assesment

## Folder Structure
- `src/test/flipkart` Added all test scripts related to Flipkart website.
- `src/test/apis` Added all test scripts related to APIs.
- `src/test/pojo` Contains all POJO classes related to APIs.


## Document received for assesment
Choose any one of the following cases and share the automation steps or
coding.
A. Web Automation
This assignment would require you to do some things on the Flipkart website. We
intentionally do not want to provide specific test cases to you as we would like to see how
you go about finding asserts for some open-ended cases.
1. Search - open www.flipkart.com (it would show a popup, you need to cancel the popup),
perform a search for term 'shoes', you now need to verify that the values on the search page
are actually searched for shoes.
2. Apply Filters - You can choose two filters - eg - price & brand. You need to ensure the
filters are selected. Again this is left a bit open-ended for you to come up with the asserts
yourself.
3. Product Detail Page - Open the detail page of the first result, select the size of the item &
then click 'buy now'. You should be on login page now.
_________________________________________________________________
B. API Automation
This is the API SDET assignment of Locus. As part of this assignment, you would need to
test some cases with the APIs mentioned at https://the-one-api.dev/documentation. The
asserts part is intentionally kept 'open ended' to gauge your skills around judgement.
1. Get books data - hit API endpoint https://the-one-api.dev/v2/book . It should return 3
books.
2. Negative case for getting movies - hit API endpoint https://the-one-api.dev/v2/movie.
Check for the negative case.
3. Positive case for getting movies - hit same endpoint as above but with Bearer token
4qAaXynbVomwqHwO6MXW . Assert on the correct response.
4. Two step case - get the list of movies from the above case & now you need to get the
quote of a movie from the url https://the-one-api.dev/v2/movie/{id}/quote where id is the id of
the one the movies returned from the above url. Assert for the usecase working fine.
