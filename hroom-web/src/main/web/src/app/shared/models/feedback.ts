export interface feedback {
  subject: number; // 1-tenant, 2-landlord
  landlordId: number;
  tenantId: number;
  insertionId: number;
  rating: number; // 0..5
  description: string;
  timestamp: string;
}
