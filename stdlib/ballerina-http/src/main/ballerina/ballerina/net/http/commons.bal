package ballerina.net.http;

import ballerina.mime;

function getFirstHeaderFromEntity (mime:Entity entity, string headerName) (string) {
    var headerValue, _ = (string[]) entity.headers[headerName];
    return headerValue == null ? null : headerValue[0];
}

function getHeadersFromEntity (mime:Entity entity, string headerName) (string[]) {
    var headerValue, _ = (string[]) entity.headers[headerName];
    return headerValue;
}

function getContentLengthIntValue (string strContentLength) (int) {
    var contentLength, conversionErr = <int>strContentLength;
    if (conversionErr != null) {
        contentLength = -1;
        throw conversionErr;
    }
    return contentLength;
}

function addHeaderToEntity (mime:Entity entity, string headerName, string headerValue){
    var existingValues = entity.headers[headerName];
    if (existingValues == null) {
        setHeaderToEntity(entity, headerName, headerValue);
    } else {
        var valueArray, _ = (string[]) existingValues;
        valueArray[lengthof valueArray] = headerValue;
        entity.headers[headerName] = valueArray;
    }
}

function setHeaderToEntity (mime:Entity entity, string headerName, string headerValue) {
    string[] valueArray = [headerValue];
    entity.headers[headerName] = valueArray;
}

function getValidatedEntity(InRequest request, string expectedType) (mime:Entity, mime:EntityBodyError) {
    var entity, error = request.getEntity();
    if (error != null) {
        return null, error;
    }
    string contentType = request.getHeader(mime:CONTENT_TYPE);
    string[] contentTypeSegments = contentType.split("/");
    if (lengthof contentTypeSegments == 2) {

    }
    if (request.getHeader(mime:CONTENT_TYPE) != expectedType) {
        mime:EntityBodyError err = {};
        err.msg = string `Expected {{expectedType}} but found {{request.getHeader(mime:CONTENT_TYPE)}}`;
        return null, err;
    }
    return entity, null;
}