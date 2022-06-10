package org.malinowsky.brewkit.api;

import org.malinowsky.brewkit.jpa.productType.ProductTypeDao;
import org.malinowsky.brewkit.xml.productTypes.ProductTypes;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/product-type")
public class ProductsApi {

    @Inject
    private ProductTypeDao dao;

    @POST
    @Path("/add")
    @Consumes("application/xml")
    public Response add(ProductTypes types) {
        dao.addAll(types.getProductType());
        return Response.ok().build();
    }
}
