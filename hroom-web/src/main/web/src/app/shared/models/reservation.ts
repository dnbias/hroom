export interface Reservation {
  id?: number;
  transactionId: number;
  checkInId: number;
  checkOutId: number;
  tenantId: number;
  insertionId: number;
}
