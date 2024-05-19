import { feedback } from "./feedback";

export interface feedbackOfTenant extends feedback {
  landlord_id: number;
  tenant_id: number;
}
